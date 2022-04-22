	.data
fmt1:	.asciz	"%d"
msg1:	.asciz	"\nEnter a number: "
msg2:	.asciz	"The average is %d\n"
msg3:	.asciz	"Incorrect input.\n"
	.align	2
	.text
	.global main

	// Register info (cin)
	// R0 = Format String
	// R1 = buffer
	// R3 = Result
	// R4 = Location of Array (first element)
	// R5 = Iterator (array size)
	// R6 = Temp variable

cin:	stmfd	sp!, {r4, r5, r6, lr}
	mov	r5, #0		// Move 0 into r5
	mov	r6, r4		// Load location of sp into r6

lp:				// Input loop
	
	// Print 'Enter number: '
	ldr	r0, =msg1	// Load location of message1
	bl	printf		// Print message

	// Get user input
	ldr	r0, =fmt1	// Load format string
	mov	r1, r6		// Mov r6 (address of r4) into r1
	bl	scanf		// Branch to scanf

	// Check if user is done filling
	ldr	r1, [r6]	// Load array[r6] into r1
	cmp	r1, #0		// Compare r1 and 0
	beq	end		// If equal, end
	
	// Test if user input is correct
	mov	r3, r0		// Move r0 (scanf result) to r3
	cmp	r3, #1		// Compare r3 to 1
	bne	err		// Branch to err if r3 != 1

	// Store into array
	ldr	r0, [r4]	// Load r4 (base address) into r0
	str	r0, [r6], #4	// Store at next bytes
	add	r5, r5, #1	// Add to iterator

	// Test to continue loop or not
	cmp	r5, #10		// Compare r5 =< 10
	blt	lp		// Loop back if r5 < 10
	b	end		// Loop to end

err:	// Print error message if user input something bad
	ldr	r0, =msg3	// Load error message
	mov	r0, #0
	mov	r1, #0
	mov	r6, #0		// Clear variables as user did something dumb
	bl	printf		// Print message

end:	// Exit function
	mov	r0, r4		// r4 is unaltered array start
 	mov	r1, r5		// r5 is array length

	ldmfd	sp!, {r4, r5, r6, lr}
	mov	pc, lr
	
	/* AVERAGE FUNCTION -- AVERAGE FUNCTION -- AVERAGE FUNCTION */
avg:	stmfd	sp!, {r4, r5, r6, lr}
	mov	r4, r0			@ r4 is array
	mov	r5, r1			@ r5 is num_elts
	mov	r6, #0			@ r6 is sum (of elts)
	
	mov	r0, #0			@ for (i=0, i<num_elts, i++)
lp1:	cmp	r0, r5
	bge	elp1

	ldr	r1, [r4, r0, lsl #2]	@ r1 = array[i]
	add	r6, r6, r1		@ r6 is our iterator
	
	add	r0, r0, #1
	b 	lp1
	
elp1:	sdiv	r0,r6,r0		
	ldmfd	sp!, {r4, r5, r6, lr}
	mov	pc, lr
	/* AVERAGE FUNCTION -- AVERAGE FUNCTION -- AVERAGE FUNCTION */
	
main:	stmfd	sp!, {lr}	// Enter function
	sub	sp, sp, #40	// Sub 40 bytes from sp (10 ints)
	mov	r4, sp		// Load location of sp into r4
	
	bl	cin		// Branch link to cin
	bl	avg		// Branch to Average Function

	mov	r1, r0
	ldr	r0, =msg2
	bl	printf
	
	add	sp, sp, #40	// Add 40 bytes to sp
	mov	r0, #0		// Return 0
	ldmfd	sp!, {lr}	// Exit function
	mov	pc, lr
