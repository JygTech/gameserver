// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MsgChat.proto

package org.jyg.gameserver.proto;

public final class MsgChat {
  private MsgChat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_jyg_gameserver_proto_MsgChatRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_jyg_gameserver_proto_MsgChatRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_jyg_gameserver_proto_MsgChatReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_jyg_gameserver_proto_MsgChatReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rMsgChat.proto\022\030org.jyg.gameserver.prot" +
      "o\"!\n\016MsgChatRequest\022\017\n\007content\030\001 \001(\t\"0\n\014" +
      "MsgChatReply\022\017\n\007account\030\001 \001(\t\022\017\n\007content" +
      "\030\002 \001(\tB\034\n\030org.jyg.gameserver.protoP\001b\006pr" +
      "oto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_org_jyg_gameserver_proto_MsgChatRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_jyg_gameserver_proto_MsgChatRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_jyg_gameserver_proto_MsgChatRequest_descriptor,
        new java.lang.String[] { "Content", });
    internal_static_org_jyg_gameserver_proto_MsgChatReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_org_jyg_gameserver_proto_MsgChatReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_jyg_gameserver_proto_MsgChatReply_descriptor,
        new java.lang.String[] { "Account", "Content", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
