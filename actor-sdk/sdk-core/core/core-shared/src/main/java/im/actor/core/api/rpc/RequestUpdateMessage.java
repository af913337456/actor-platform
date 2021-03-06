package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import im.actor.core.api.*;

public class RequestUpdateMessage extends Request<ResponseSeqDate> {

    public static final int HEADER = 0xa62;
    public static RequestUpdateMessage fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestUpdateMessage(), data);
    }

    private ApiOutPeer peer;
    private long rid;
    private ApiMessage updatedMessage;

    public RequestUpdateMessage(@NotNull ApiOutPeer peer, long rid, @NotNull ApiMessage updatedMessage) {
        this.peer = peer;
        this.rid = rid;
        this.updatedMessage = updatedMessage;
    }

    public RequestUpdateMessage() {

    }

    @NotNull
    public ApiOutPeer getPeer() {
        return this.peer;
    }

    public long getRid() {
        return this.rid;
    }

    @NotNull
    public ApiMessage getUpdatedMessage() {
        return this.updatedMessage;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.peer = values.getObj(1, new ApiOutPeer());
        this.rid = values.getLong(2);
        this.updatedMessage = ApiMessage.fromBytes(values.getBytes(3));
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.peer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.peer);
        writer.writeLong(2, this.rid);
        if (this.updatedMessage == null) {
            throw new IOException();
        }

        writer.writeBytes(3, this.updatedMessage.buildContainer());
    }

    @Override
    public String toString() {
        String res = "rpc UpdateMessage{";
        res += "peer=" + this.peer;
        res += ", rid=" + this.rid;
        res += ", updatedMessage=" + this.updatedMessage;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
