package jas;

import java.io.*;

class MultiANewArrayInROperand extends InsnOperand implements RuntimeConstants
{
    CP cpe;
    int reg;
    int sz;
    boolean wide;

    int size(ClassEnv env, CodeAttr codea) {
        return ((reg <= 255)?4:6);
    }

    MultiANewArrayInROperand(int region, CP cp, int dim) {
        cpe = cp;
        reg = region;
        wide = true;
        sz = dim;
    }

    MultiANewArrayInROperand(int region, CP cp, int dim, boolean iswide) {
        cpe = cp;
        reg = region;
        wide = iswide;
        sz = dim;
    }

    void resolve(ClassEnv env) {
        env.addCPItem(cpe);
    }

    void writePrefix(ClassEnv env, CodeAttr codea, DataOutputStream out) throws IOException, jasError {
        if (reg > 255) out.writeByte((byte) opc_wide);
    }

    void write(ClassEnv env, CodeAttr codea, DataOutputStream out) throws IOException, jasError {
        int index;
        index = env.getCPIndex(cpe);

        if (reg <= 255) 
            out.writeByte((byte) reg & 0xff);
        else 
            out.writeShort((short) reg & 0xffff);

        if (wide)
            out.writeShort((short) index);
        else {
            if (index <= 255)
                out.writeByte((byte) (0xff & index));
            else
                throw new jasError("exceeded size for small cpidx" + cpe);
        }

        out.writeByte((byte) sz & 0xff);
    }
}
