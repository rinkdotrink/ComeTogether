   @Override
   protected void configure() {
      bind(Generator.class);
      bind(Creator.class);
      bind(WKorbGenerator.class);
      bind(KundenGenerator.class);
      bind(ProduktGenerator.class);
      bind(WKorbProduktGenerator.class);
      bind(IDBWriter.class).annotatedWith(Names.named("Kunde")).to(DBKundeWriter.class);
      bind(IDBWriter.class).annotatedWith(Names.named("Produkt")).to(DBProduktWriter.class);
      bind(IDBWriter.class).annotatedWith(Names.named("WKorb")).to(DBWKorbWriter.class);
      bind(IDBWriter.class).annotatedWith(Names.named("WKorbProdukt")).to(DBWKorbProduktWriter.class);
   }