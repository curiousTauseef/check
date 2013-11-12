package jas;

import java.io.*;

/* jreg new operand for newarray and create_rb */
class TwoByteWideOp extends InsnOperand implements RuntimeConstants
{
    int reg;
    int code;
    boolean wide;

    int size(ClassEnv env, CodeAttr codea) {
        return ((reg <= 255)?2:4);
    }

    TwoByteWideOp(int region, int type) {
        code = type;
        reg = region;
        wide = true;
    }

    TwoByteWideOp(int region, int type, boolean iswide) {
        code = type;
        reg = region;
        wide = iswide;
    }

    void resolve(ClassEnv env) { }

    void writePrefix(ClassEnv env, CodeAttr codea, DataOutputStream out) 
        throws java.io.IOException, jas.jasError {
        if (reg > 255) {
            out.writeByte((byte) opc_wide);
        }
    }

    void write(ClassEnv env, CodeAttr codea, DataOutputStream out) 
        throws java.io.IOException, jas.jasError
    {
        if (reg <= 255) 
            out.writeByte((byte) reg & 0xff);
        else 
            out.writeShort((short) reg & 0xffff);
        out.writeByte((byte) code & 0xff);
    }
}
