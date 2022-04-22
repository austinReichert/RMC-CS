	.data			@ data segment
wordA:	.asciz	"racecar"
	.text			@ text segment
	.global main
/*
r0 = *a CHARACTER FROM THE WORD
r1 = *b 	
r2 = a WORD
r3 = b
r4 = (b*+1) one index ahead
r5 = base address
r6 = iterator for A
r7 = iterator for B
r8 = iterator +1 (for r4)
*/

palin:	stmfd sp!, {lr}		@ push link register on stack (starts function)

	// (*(b+1) != 0) b++  
lp1:	cmp	r4, #0		@ *b+1 to #0
	beq	elp1		@ if (*(b+1) != 0)
	
	//(*a == *b && a < b)
lp2:	cmp	r0, r1		@ a* to *b (r0 and r1)
	bne	elp2		@ if *a == *b (if r0 == r1)
	cmp	r2, r3		@ a to b (r2 and r3)
	bge	elp2		@ if a < b (if r2 < r3)
	add	r2, r2, #1	@ a++
	ldrb	r0, [r5, r2]	@ update *a
	sub	r3, r3, #1	@ b--
	ldrb	r1, [r5, r3]	@ update *b
	b	lp2		@ loop again
elp2:
	add	r8, r8, #1	@ b + 1 (so we can continue the FOR LOOP)
	ldrb	r4, [r5, r8]	@ update r4 so its (*b+1)
	b	lp1
elp1:
	//return statement is dealt with in main	
	ldmfd	sp!, {lr}	@ pop lr from stack
	mov	pc, lr		@ return to caller (closes func)
	
main:	stmfd	sp!, {lr}	@ push lr on sp (starts main func)
	ldr	r5, =wordA	@ make r5 the word 'racecar'
	mov	r2, #0		@ make r2 = 0
	mov	r3, #6		@ make r3 = 6
	ldrb	r0, [r5, r2]	@ load char 'r' into r0 / r.0, a.1, c.2, e.3, c.4, a.5, r.6, 0.7
	ldrb	r1, [r5, r3]	@ load char 'r' into r1
	mov	r8, #1		@ make r8 = 1
	ldrb	r4, [r5, r8]	@ load r4 to be (b+1)
	
	bl	palin		@ branches out to palindrome function
	sub 	r0, r0, r1	@ returns the difference from r0 and r1 to r0

	ldmfd	sp!, {lr}	@ pop lr from sp
	mov	pc, lr		@ return to caller (closes func)
				@ if r0 != 0 then not a palindrome... or didnt work.
/*	
r0 = *a CHARACTER FROM THE WORD
r1 = *b 	
r2 = a WORD
r3 = b
r4 = (b*+1) one index ahead
r5 = base address
r6 = iterator for A
r7 = iterator for B
r8 = iterator +1 (for r4)
*/
