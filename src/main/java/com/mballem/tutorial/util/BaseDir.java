package com.mballem.tutorial.util;

import java.io.File;

/**
 * Inclua em PATH_ROOT o diretorio raiz onde os arquivos serao armazenados.
 */
public class BaseDir {

    public static final String PATH_ROOT = System.getProperty("user.home") +
            File.separator + "Documents" + File.separator + "uploads";
}
