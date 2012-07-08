   @Inject
   public KundenGenerator(final Creator aCreator, @Named("Kunde") final IDBWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }