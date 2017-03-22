package com.pingconsole.resttest;

import static org.mockito.Mockito.when;

import org.junit.Test;

public class RestAPIGetTest {

  @Test
  public void simpleGETRestTest() {
    when().get("/lotto/{id}", 5).then().statusCode(200).body("lotto.lottoId", equalTo(5),
        "lotto.winners.winnerId", containsOnly(23, 54));
  }

}
