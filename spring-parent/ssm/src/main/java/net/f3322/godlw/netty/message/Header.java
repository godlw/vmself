package net.f3322.godlw.netty.message;

public class Header {

    private byte tag;
    private byte encode;
    private byte encrypt;
    private byte extend1;
    private byte extend2;
    private String sessionid;
    private int length=1024;
    private int cammand;


    public Header(byte tag, byte encode, byte encrypt, byte extend1, byte extend2, String sessionid, int length, int cammand) {
        this.tag = tag;
        this.encode = encode;
        this.encrypt = encrypt;
        this.extend1 = extend1;
        this.extend2 = extend2;
        this.sessionid = sessionid;
        this.length = length;
        this.cammand = cammand;
    }

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public byte getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(byte encrypt) {
        this.encrypt = encrypt;
    }

    public byte getExtend1() {
        return extend1;
    }

    public void setExtend1(byte extend1) {
        this.extend1 = extend1;
    }

    public byte getExtend2() {
        return extend2;
    }

    public void setExtend2(byte extend2) {
        this.extend2 = extend2;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCammand() {
        return cammand;
    }

    public void setCammand(int cammand) {
        this.cammand = cammand;
    }
}
