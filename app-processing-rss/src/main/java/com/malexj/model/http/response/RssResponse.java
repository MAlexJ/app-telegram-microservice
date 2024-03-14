package com.malexj.model.http.response;

import com.malexj.model.RssItem;
import java.util.List;

public record RssResponse(List<RssItem> items, int total) {

  public RssResponse(List<RssItem> items) {
    this(items, items.size());
  }
}
