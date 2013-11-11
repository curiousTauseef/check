#
# (C) Copyright IBM Corp. 2001, 2003
#
# $Id: Makefile,v 1.7 2003/09/12 22:06:17 augart-oss Exp $
#
# @author Stephen Fink
# @author David Grove
include		$(RVM_BUILD)/Make.rules.host
SHELL=${BASH}			# Set shell to bash because we use 'echo -n' 
			        # below, and /bin/sh on AIX does not support
                                # 'echo -n'.

MakeTemplates:;	(cd ir/instruction && $(MAKE))
		(cd ir/conversions/lir2mir && $(MAKE))
		(cd driver && $(MAKE))
		(cd optimizations/local/instructionScheduler && $(MAKE))
		@echo -n "(opt templates expanded) "

.PHONY: MakeTemplates
