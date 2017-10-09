package org.brewtraption.server;

import org.brewtraption.util.BreweryProperties;

public class JettyServerConfig {
  private String hostname = "localhost";
  private int port = 8080;
  private boolean consoleMetrics = false;

  public int getPort() {
    return port;
  }

  public String getHostname() {
    return hostname;
  }

  public boolean isConsoleMetrics() {
    return consoleMetrics;
  }

  public static class Builder {
    private String hostname;
    private int port;
    private boolean consoleMetrics;

    public Builder hostname(final String hostname) {
      this.hostname = hostname;
      return this;
    }

    public Builder port(final int port) {
      this.port = port;
      return this;
    }

    public Builder consoleMetrics(final boolean consoleMetrics) {
      this.consoleMetrics = consoleMetrics;
      return this;
    }

    public JettyServerConfig build() {
      return new JettyServerConfig(this);
    }
  }

  private JettyServerConfig(final Builder builder) {
    this.hostname = builder.hostname;
    this.port = builder.port;
    this.consoleMetrics = builder.consoleMetrics;
  }

  //TODO refactor out builder pattern, it's a bit overkill as we'll a have a props file anyway
  public JettyServerConfig() {
    this.hostname = BreweryProperties.lookupString("jetty.bind.host");
    this.port = BreweryProperties.lookupInt("jetty.bind.port");
    this.consoleMetrics = BreweryProperties.lookupBoolean("jetty.metrics");
  }
}