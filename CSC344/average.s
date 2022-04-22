	.data
array:	.word	894, 437, 694, 788, 302, 189, 842, 557, 257, 222
ofmt:	.asciz	"the average is %d\n"
	.align	2
	.text
	.global main

	// R0 = Array
	// R1 = 10 (array length)
	// R2 = 0 (iterator)
	// R3 = storage
	// R4 = maths
	// R5 = bytes
	
avg:	stmfd	sp!, {lr}
	mov	r2, #0		// Makes r2 = 0*
	mov	r3, #0		// Makes r3 = 0*
	mov	r4, #0		// Makes r4 = 0*
	mov	r5, #0		// Makes r5 = 0*
avf:	
	cmp	r1, r2		// Compare r1 and r2
	beq	endlp		// if(r1==r2) end
	ldr	r3, [r0, r5]	// Load element into r3 for maths
	add	r4, r4, r3	// Add r3 to r4
	
	add	r5, r5, #4	// Element value (4 bytes)
	add	r2, r2, #1	// Add 1 to r2
	b	avf		// Loop back to avf:
endlp:
	sdiv	r0, r4, r1	// Divide r4/r1 and put result in r0
	ldmfd	sp!, {lr}
	mov	pc, lr		// exit funct

main:	stmfd	sp!, {lr}	// enter funct

	ldr	r0, =array	// Load location of array into r0
	mov	r1, #10		// Makes r1 = 10
	bl	avg		// Branch out to avg
	mov	r1, r0		// Copy r0 to r1
	ldr	r0, =ofmt	// Load the output str into r0
	bl	printf		// Branch to prinf
	mov	r0, #0		// Return r0
	ldmfd	sp!, {lr}	// exit funct
	mov	pc, lr
