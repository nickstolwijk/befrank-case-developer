# Case sollicitatie developer BeFrank
### Hoi! :wave:
Leuk dat je solliciteert bij BeFrank! Deze opdracht is bedoeld om inzicht te krijgen in je vaardigheden als Java developer.
De opdracht zal ongeveer 4 uur in beslag nemen en lijkt enigszins op een hackathon die we regelmatig bij BeFrank organiseren. Mocht je
vast komen te zitten of merken dat je teveel tijd aan een bepaald onderdeel besteedt, probeer dan de simpelste
oplossing die wel werkt te gebruiken. Het is niet de bedoeling om een productie-ready applicatie te maken.

### De opdracht :page_facing_up:
Implementeer een eenvoudige web applicatie voor de deelnemer bij BeFrank, waarmee hij inzicht kan krijgen in
de verwachte waarde van zijn pensioenpot op zijn pensioendatum. De web applicatie zal de gegevens lezen uit
een onderliggende database en gebruik maken van een REST koppeling met een externe beleggingservice om de
huidige waarde van de beleggingsrekening op te halen. De deelnemer heeft de mogelijkheid om zijn verwachte
pensioenleeftijd aan te passen en ziet dan wat voor effect dit heeft op zijn pensioenpot.
```mermaid
  graph LR;
      A[Frontend]-->|Aanpassen pensioenleeftijd|B[Web applicatie];
      B[Web applicatie]-->|Tonen effect op pensioenpot|A[Frontend];
      
      B[Web applicatie]-.->|Ophalen beleggingen|C[Externe beleggingsservice];
      C[Externe beleggingsservice]-.->B[Web applicatie];
      style A fill:#f9f,stroke:#333,stroke-width:4px
      style B fill:#f9f,stroke:#333,stroke-width:4px
      style C fill:#bbf,stroke:#f66,stroke-width:2px,color:#fff,stroke-dasharray: 5 5
```


#### Data model
Een deelnemer bij BeFrank is een (ex-)werknemer bij een werkgever die een pensioenregeling heeft bij BeFrank.
Voor deze deelnemer hebben we in ieder geval NAW gegevens nodig, een e-mailadres en zijn geboortedatum.
De deelnemer heeft een dienstverband met zijn werkgever, waarbij zijn salaris bepaalt hoeveel pensioenpremie
maandelijks op de pensioenrekening wordt gestort. De pensioenrekening zelf is een beleggingsrekening die door
een externe partij wordt beheerd en waarvan we alleen het rekeningnummer hoeven vast te leggen.

#### Berekeningen :computer:
##### Jaarlijkse premie
Indien de deelnemer nog in dienst is bij de werkgever, dan zal maandelijks een premie gestort worden op de beleggingsrekening die afhankelijk is van:

- Full-time salaris
- Parttime percentage
- Franchise in de regeling (voor nu: vastgesteld op 15.599, -)
- Beschikbare premie percentage (voor nu: vast percentage van 5%)

De **jaarlijkse premiestorting** kan je berekenen met de volgende formule:

```(Full-time salaris – Franchise) * Parttime percentage * Beschikbare premie percentage```

Indien de deelnemer uit dienst is, dan wordt er geen premie meer gestort.

##### Verwachte waarde :moneybag:
De (vereenvoudigde) berekening van de verwachte waarde van de pensioenrekening is afhankelijk van de
volgende gegevens:
- Huidige leeftijd van de deelnemer
- Gewenste pensioenleeftijd van de deelnemer
- Huidige waarde van de beleggingen
- Jaarlijkse premie storting
- Jaarlijks rendement op de beleggingen (voor eenvoud van deze opdracht: vast rendement van 3%)

De berekening van de **verwachte waarde van de pensioenrekening** is (voor ieder jaar tot aan zijn pensioen):

```Huidige waarde + Jaarlijkse premiestorting + (Huidige waarde + Jaarlijkse premiestorting/2) * rendement```


#### Externe beleggingsservice
De beleggingsservice biedt een REST interface, die voor een gegeven rekeningnummer retourneert in welke
fondsen momenteel belegd wordt en wat de waarde per fonds is. De totale waarde van de beleggingsrekening is
de som van de waarde in de fondsen. Deze service hoeft niet volledig geïmplementeerd te worden, maar kan
vervangen worden door een mock API.

### Aan de slag!
Gebruik in het uitwerken van de case de volgende technieken:
- Minimaal Java 11
- Spring Boot
- Angular
- Een SQL database implementatie (gebruik hiervoor bijvoorbeeld een docker image om snel aan de slag te kunnen)
- JUnit, Mockito

Heb je het afgerond?
Stuur dan de broncode en een korte beschrijving van je oplossing met een paar screenshots van de werkende
applicatie op. BeFrank zal de oplossing beoordelen en in je tweede gesprek kan je de gemaakte keuzes verder toelichten.

**:grey_question: Mocht je vragen hebben, schroom niet om contact op te nemen!**
