// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MsgBytes.proto

package org.jyg.gameserver.core.proto;

/**
 * <pre>
 *option java_outer_classname = "MsgBytes";
 *sm服 ping场景服
 * </pre>
 *
 * Protobuf type {@code org.jyg.gameserver.core.proto.MsgBytes}
 */
public  final class MsgBytes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.jyg.gameserver.core.proto.MsgBytes)
    MsgBytesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MsgBytes.newBuilder() to construct.
  private MsgBytes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MsgBytes() {
    id_ = 0;
    byteDate_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MsgBytes(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 18: {

            byteDate_ = input.readBytes();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.jyg.gameserver.core.proto.MsgBytesOuterClass.internal_static_org_jyg_gameserver_core_proto_MsgBytes_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.jyg.gameserver.core.proto.MsgBytesOuterClass.internal_static_org_jyg_gameserver_core_proto_MsgBytes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.jyg.gameserver.core.proto.MsgBytes.class, org.jyg.gameserver.core.proto.MsgBytes.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int BYTEDATE_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString byteDate_;
  /**
   * <code>bytes byteDate = 2;</code>
   */
  public com.google.protobuf.ByteString getByteDate() {
    return byteDate_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (!byteDate_.isEmpty()) {
      output.writeBytes(2, byteDate_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (!byteDate_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, byteDate_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.jyg.gameserver.core.proto.MsgBytes)) {
      return super.equals(obj);
    }
    org.jyg.gameserver.core.proto.MsgBytes other = (org.jyg.gameserver.core.proto.MsgBytes) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && getByteDate()
        .equals(other.getByteDate());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + BYTEDATE_FIELD_NUMBER;
    hash = (53 * hash) + getByteDate().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.jyg.gameserver.core.proto.MsgBytes parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.jyg.gameserver.core.proto.MsgBytes prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *option java_outer_classname = "MsgBytes";
   *sm服 ping场景服
   * </pre>
   *
   * Protobuf type {@code org.jyg.gameserver.core.proto.MsgBytes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.jyg.gameserver.core.proto.MsgBytes)
      org.jyg.gameserver.core.proto.MsgBytesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.jyg.gameserver.core.proto.MsgBytesOuterClass.internal_static_org_jyg_gameserver_core_proto_MsgBytes_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.jyg.gameserver.core.proto.MsgBytesOuterClass.internal_static_org_jyg_gameserver_core_proto_MsgBytes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.jyg.gameserver.core.proto.MsgBytes.class, org.jyg.gameserver.core.proto.MsgBytes.Builder.class);
    }

    // Construct using org.jyg.gameserver.core.proto.MsgBytes.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0;

      byteDate_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.jyg.gameserver.core.proto.MsgBytesOuterClass.internal_static_org_jyg_gameserver_core_proto_MsgBytes_descriptor;
    }

    public org.jyg.gameserver.core.proto.MsgBytes getDefaultInstanceForType() {
      return org.jyg.gameserver.core.proto.MsgBytes.getDefaultInstance();
    }

    public org.jyg.gameserver.core.proto.MsgBytes build() {
      org.jyg.gameserver.core.proto.MsgBytes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.jyg.gameserver.core.proto.MsgBytes buildPartial() {
      org.jyg.gameserver.core.proto.MsgBytes result = new org.jyg.gameserver.core.proto.MsgBytes(this);
      result.id_ = id_;
      result.byteDate_ = byteDate_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.jyg.gameserver.core.proto.MsgBytes) {
        return mergeFrom((org.jyg.gameserver.core.proto.MsgBytes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.jyg.gameserver.core.proto.MsgBytes other) {
      if (other == org.jyg.gameserver.core.proto.MsgBytes.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (other.getByteDate() != com.google.protobuf.ByteString.EMPTY) {
        setByteDate(other.getByteDate());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.jyg.gameserver.core.proto.MsgBytes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.jyg.gameserver.core.proto.MsgBytes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString byteDate_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes byteDate = 2;</code>
     */
    public com.google.protobuf.ByteString getByteDate() {
      return byteDate_;
    }
    /**
     * <code>bytes byteDate = 2;</code>
     */
    public Builder setByteDate(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      byteDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes byteDate = 2;</code>
     */
    public Builder clearByteDate() {
      
      byteDate_ = getDefaultInstance().getByteDate();
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:org.jyg.gameserver.core.proto.MsgBytes)
  }

  // @@protoc_insertion_point(class_scope:org.jyg.gameserver.core.proto.MsgBytes)
  private static final org.jyg.gameserver.core.proto.MsgBytes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.jyg.gameserver.core.proto.MsgBytes();
  }

  public static org.jyg.gameserver.core.proto.MsgBytes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MsgBytes>
      PARSER = new com.google.protobuf.AbstractParser<MsgBytes>() {
    public MsgBytes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MsgBytes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MsgBytes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MsgBytes> getParserForType() {
    return PARSER;
  }

  public org.jyg.gameserver.core.proto.MsgBytes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

