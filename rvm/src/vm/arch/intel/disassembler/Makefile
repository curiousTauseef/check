#
# (C) Copyright IBM Corp. 2001, 2005
#
# $Id: Makefile,v 1.4 2005/01/26 10:31:09 augart-oss Exp $
#
# @author Ton Ngo
include		$(RVM_BUILD)/Make.rules.target

.SUFFIXES:	.c .C .o .h

.C.o:
	gcc -funsigned-bitfields -I. -I$(JAL_ROOT)/rvm/src/include -g -c $<

.c.o:
	gcc -funsigned-bitfields -I. -I$(JAL_ROOT)/rvm/src/include -g -c $<
disasm.o: disasm.C disasm.h
	gcc -funsigned-bitfields -g -c disasm.C

clean:
	rm -f *.o 
