#
# (C) Copyright IBM Corp. 2001
#
# $Id: Makefile,v 1.7 2003/08/13 20:08:32 dgrove-oss Exp $
#
# @author Julian Dolby

include		$(RVM_BUILD)/Make.rules.target

BENCH_NAME=CaffeineMark
include		$(JAL_ROOT)/rvm/regression/Local.rules

BENCH_CLASS_PATH=$(BENCH_HOME)
BENCH_SOURCE_PATH=$(BENCH_HOME)
HEAPSIZE=200
START_NAME=RunCaffeine

include		$(JAL_ROOT)/rvm/regression/Make.rules

sanity:		sanity-check-rule

check:
	@$(FGREP) -q "Method score:" $(OUT)

do-gather-performance:
	cat $(OUT) >> $(PERF_LOG)

