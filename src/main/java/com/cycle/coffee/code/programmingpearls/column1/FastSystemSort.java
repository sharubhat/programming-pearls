package com.cycle.coffee.code.programmingpearls.column1;

/**
 * Questions to ask and sample answers:
 * 1. Why do you want to write your own sort at all? Why not use a sort provided by your system?
 * - I need the sort in the middle of a large system, and for obscure technical reasons, I can’t use the system file-sorting program.
 * 2. What exactly are you sorting? How many records are in the file? What is the format of each record?
 * - The file contains at most ten million records; each record is a seven-digit integer.
 * 3. If the file is that small, why bother going to disk at all? Why not just sort it in main memory?
 * - Although the machine has many megabytes of main memory, this function is part of a big system. I expect that I’ll have only about a megabyte free at that point.
 * 4. Is there anything else you can tell me about the records?
 * - Each one is a seven-digit positive integer with no other associated data, and no integer can appear more than once.
 *
 * Formal statement:
 * Input: A file containing at most n positive integers, each less than n, where n = 10^7.
 * It is a fatal error if any integer occurs twice in the input. No other data is associated with the integer.
 * Output: A sorted list in increasing order of the input integers.
 * Constraints: At most (roughly) a megabyte of storage is available in main memory; ample disk storage is available.
 * The runtime can be at most several minutes; a runtime of ten seconds need not be decreased.
 *
 * Approach 1:
 * Use merge sort that uses disk to store many intermediate files but writes the output at once.
 *
 * Approach 2:
 * If we represent each number as a 32-bit integer, we can store 250,000 numbers in the megabyte.
 * - How? Each byte is 8 bits. So, an integer takes 4 bytes. i.e. approximately 1million/4 ~= 250,000
 * So we can make 40 passes of this program to sort 10 million records.
 *
 * Approach 3:
 * What we need is combination of the two, i.e. read the input once, hold everything in memory and write the output at once.
 * The problem boils down to representing 10 million distinct integers in about 8 million available bits.
 *
 */
public class FastSystemSort {

}
