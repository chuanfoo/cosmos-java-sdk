package io.cosmos.msg;

import io.cosmos.crypto.Crypto;
import io.cosmos.delegate.sign.entity.*;
import io.cosmos.types.*;
import io.cosmos.util.EncodeUtils;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MsgRedelegate extends MsgDelegate {
    String validatorDstAddress;
    public static void main(String[] args) {
        MsgRedelegate msg = new MsgRedelegate();

        msg.setMsgType("cosmos-sdk/MsgBeginRedelegate");
        msg.setValidatorSrcAddress("cosmosvaloper1l25rrm7vrmzgqcplp5s7c8edeljxt78gmuqs0a");
        msg.setValidatorDstAddress("cosmosvaloper1uhfa9260p3xhnac74wgx5er7tpltww78gxeac0");

        msg.submit("stake",
                "3",
                "200000",
                "testchain",
                "stake",
                "100",
                "2c999c5afe7f0c902846e1b286fed29c5c5914998655d469568560955abe0d5d");
    }

    public void setValidatorDstAddress(String addr) {
        this.validatorDstAddress = addr;
    }
    public void setValidatorSrcAddress(String addr) {
        this.setValidatorAddress(addr);
    }

    protected MessageDelegateMulti[] produceDelegateMsg(String delegateDenom, String delegateAmount) {
        //make tx.msg
        MsgBeginRedelegateValue delegateValue = new MsgBeginRedelegateValue();
        delegateValue.setValidatorSrcAddress(validatorAddress);
        delegateValue.setValidatorDstAddress(validatorDstAddress);
        delegateValue.setDelegatorAddress(address);
        Token token = new Token();
        token.setDenom(delegateDenom);
        token.setAmount(delegateAmount);
        delegateValue.setAmount(token);
        MessageDelegateMulti<MsgBeginRedelegateValue> messageDelegateMulti = new MessageDelegateMulti<>();
        messageDelegateMulti.setType(msgType);
        messageDelegateMulti.setValue(delegateValue);
        MessageDelegateMulti[] msgs = new MessageDelegateMulti[1];
        msgs[0] = messageDelegateMulti;
        return msgs;
    }

}
