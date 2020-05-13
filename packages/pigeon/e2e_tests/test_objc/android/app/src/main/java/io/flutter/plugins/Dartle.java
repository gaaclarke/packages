// Autogenerated from Pigeon (v0.1.0-experimental.9), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package dev.flutter.aaclarke.pigeon;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;

/** Generated class from Pigeon. */
public class Dartle {

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class SearchReply {
    private String result;

    public String getResult() {
      return result;
    }

    public void setResult(String setterArg) {
      this.result = setterArg;
    }

    private String error;

    public String getError() {
      return error;
    }

    public void setError(String setterArg) {
      this.error = setterArg;
    }

    HashMap toMap() {
      HashMap<String, Object> toMapResult = new HashMap<String, Object>();
      toMapResult.put("result", result);
      toMapResult.put("error", error);
      return toMapResult;
    }

    static SearchReply fromMap(HashMap map) {
      SearchReply fromMapResult = new SearchReply();
      fromMapResult.result = (String) map.get("result");
      fromMapResult.error = (String) map.get("error");
      return fromMapResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class SearchRequest {
    private String query;

    public String getQuery() {
      return query;
    }

    public void setQuery(String setterArg) {
      this.query = setterArg;
    }

    private Long anInt;

    public Long getAnInt() {
      return anInt;
    }

    public void setAnInt(Long setterArg) {
      this.anInt = setterArg;
    }

    private Boolean aBool;

    public Boolean getABool() {
      return aBool;
    }

    public void setABool(Boolean setterArg) {
      this.aBool = setterArg;
    }

    HashMap toMap() {
      HashMap<String, Object> toMapResult = new HashMap<String, Object>();
      toMapResult.put("query", query);
      toMapResult.put("anInt", anInt);
      toMapResult.put("aBool", aBool);
      return toMapResult;
    }

    static SearchRequest fromMap(HashMap map) {
      SearchRequest fromMapResult = new SearchRequest();
      fromMapResult.query = (String) map.get("query");
      fromMapResult.anInt =
          (map.get("anInt") instanceof Integer)
              ? (Integer) map.get("anInt")
              : (Long) map.get("anInt");
      fromMapResult.aBool = (Boolean) map.get("aBool");
      return fromMapResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class Nested {
    private SearchRequest request;

    public SearchRequest getRequest() {
      return request;
    }

    public void setRequest(SearchRequest setterArg) {
      this.request = setterArg;
    }

    HashMap toMap() {
      HashMap<String, Object> toMapResult = new HashMap<String, Object>();
      toMapResult.put("request", request);
      return toMapResult;
    }

    static Nested fromMap(HashMap map) {
      Nested fromMapResult = new Nested();
      fromMapResult.request = (SearchRequest) map.get("request");
      return fromMapResult;
    }
  }

  /** Generated class from Pigeon that represents Flutter messages that can be called from Java. */
  public static class FlutterSearchApi {
    private BinaryMessenger binaryMessenger;

    public FlutterSearchApi(BinaryMessenger argBinaryMessenger) {
      this.binaryMessenger = argBinaryMessenger;
    }

    public interface Reply<T> {
      void reply(T reply);
    }

    public void search(SearchRequest argInput, Reply<SearchReply> callback) {
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<Object>(
              binaryMessenger,
              "dev.flutter.pigeon.FlutterSearchApi.search",
              new StandardMessageCodec());
      HashMap inputMap = argInput.toMap();
      channel.send(
          inputMap,
          new BasicMessageChannel.Reply<Object>() {
            public void reply(Object channelReply) {
              HashMap outputMap = (HashMap) channelReply;
              SearchReply output = SearchReply.fromMap(outputMap);
              callback.reply(output);
            }
          });
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface NestedApi {
    SearchReply search(Nested arg);

    /** Sets up an instance of `NestedApi` to handle messages through the `binaryMessenger` */
    public static void setup(BinaryMessenger binaryMessenger, NestedApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<Object>(
                binaryMessenger, "dev.flutter.pigeon.NestedApi.search", new StandardMessageCodec());
        channel.setMessageHandler(
            new BasicMessageChannel.MessageHandler<Object>() {
              public void onMessage(Object message, BasicMessageChannel.Reply<Object> reply) {
                Nested input = Nested.fromMap((HashMap) message);
                HashMap<String, HashMap> wrapped = new HashMap<String, HashMap>();
                try {
                  SearchReply output = api.search(input);
                  wrapped.put("result", output.toMap());
                } catch (Exception exception) {
                  wrapped.put("error", wrapError(exception));
                }
                reply.reply(wrapped);
              }
            });
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface Api {
    SearchReply search(SearchRequest arg);

    /** Sets up an instance of `Api` to handle messages through the `binaryMessenger` */
    public static void setup(BinaryMessenger binaryMessenger, Api api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<Object>(
                binaryMessenger, "dev.flutter.pigeon.Api.search", new StandardMessageCodec());
        channel.setMessageHandler(
            new BasicMessageChannel.MessageHandler<Object>() {
              public void onMessage(Object message, BasicMessageChannel.Reply<Object> reply) {
                SearchRequest input = SearchRequest.fromMap((HashMap) message);
                HashMap<String, HashMap> wrapped = new HashMap<String, HashMap>();
                try {
                  SearchReply output = api.search(input);
                  wrapped.put("result", output.toMap());
                } catch (Exception exception) {
                  wrapped.put("error", wrapError(exception));
                }
                reply.reply(wrapped);
              }
            });
      }
    }
  }

  private static HashMap wrapError(Exception exception) {
    HashMap<String, Object> errorMap = new HashMap<String, Object>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", null);
    errorMap.put("details", null);
    return errorMap;
  }
}
