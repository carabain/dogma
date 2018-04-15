package com.carabain.dogma.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Dogma web configuration.
 */
@ApplicationPath("/*") // Enables REST services without the need for a web.xml.
public class DogmaConfig extends Application {
}
