Feature: Case calculator
  Optional description of the feature
  Scenario: Jane Doe has a case
    Given een deelnemer met de naam "Jane Doe"
    Given de deelnemer is 60 jaar oud
    Given een huidige waarde van 100,000 euro
    Given een full-time salaris van 60,000 euro
    Given een part-time percentage van 80.0%
    Given een franchise van 15,599 euro
    Given een beschikbare premie percentage van 5.0%
    Given een rendement van 3.0% per jaar
    When een gewenste pensioenleeftijd van 61 jaar
    #Then een verwachte waarde op pensioendatum van 104802.68 euro
    Then een verwachte waarde op pensioendatum van 157243.98 euro

  Scenario: John Doe has a case
    Given een deelnemer met de naam "John Doe"
    Given de deelnemer is 60 jaar oud
    Given een huidige waarde van 100,000 euro
    Given een full-time salaris van 60,000 euro
    Given een part-time percentage van 80.0%
    Given een franchise van 15,599 euro
    Given een beschikbare premie percentage van 5.0%
    Given een rendement van 3.0% per jaar
    When een gewenste pensioenleeftijd van 65 jaar
    #Then een verwachte waarde op pensioendatum van 125498.08 euro
    Then een verwachte waarde op pensioendatum van 157243.98 euro
