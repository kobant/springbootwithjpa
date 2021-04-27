package com.example.springbootwithjpa.exception;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/4/27 14:15
 */
public class JMException extends RuntimeException {

    private int errCode = -1;
    private String msgZ;
    private String msgE;
    public JMException() {
        super();
    }

    public JMException(String msgZ) {
        super(msgZ);
        this.msgZ = msgZ;
    }

    public JMException(int errCode) {
        this.errCode = errCode;
    }

    public JMException(int errCode, String msgZ) {
        super(msgZ);
        this.errCode = errCode;
        this.msgZ = msgZ;
    }
    public JMException(int errCode, String msgZ,String msgE) {
        super(msgZ);
        this.errCode = errCode;
        this.msgZ = msgZ;
        this.msgE = msgE;
    }
    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getMsgZ() {
        return msgZ;
    }

    public void setMsgZ(String msgZ) {
        this.msgZ = msgZ;
    }

    public String getMsgE() {
        return msgE;
    }

    public void setMsgE(String msgE) {
        this.msgE = msgE;
    }

}