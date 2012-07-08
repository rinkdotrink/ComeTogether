      Injector injector = Guice.createInjector(new DBModule());
      Generator dataGenStrat = injector.getInstance(Generator.class);