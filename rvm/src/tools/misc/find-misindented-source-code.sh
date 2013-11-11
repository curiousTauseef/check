#! /usr/bin/env bash
# -*- coding: iso-8859-1 ; mode: shell-script ;-*-
# (C) Copyright © IBM Corp. 2003
#
# $Id: find-misindented-source-code.sh,v 1.1 2003/11/22 00:15:34 augart-oss Exp $
#
# Simple program that hunts for files that don't meet our 
# four-space indentation criterion.
#
# @author Steven Augart
# @date 21 November 2003

cd $RVM_ROOT/rvm
find . -name \*.sh | xargs egrep '^(    )*  ? ?[^ ]'
echo "This output will be less useful; false positives inside comments:"
find . -name \*.{C,java,c,h} | xargs egrep '^(    )*  ? ?[^ ]'
