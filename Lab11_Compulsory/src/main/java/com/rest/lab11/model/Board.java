package com.rest.lab11.model;

import java.util.List;

public class Board {
   List<String> rows;

   public Board(List<String> rows) {
      this.rows = rows;
   }

   public List<String> getRows() {
      return rows;
   }

   public void setRows(List<String> rows) {
      this.rows = rows;
   }
}
