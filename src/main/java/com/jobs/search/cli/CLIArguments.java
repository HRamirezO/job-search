package com.jobs.search.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    CLIArguments() {
    }

    @Parameter(
        required = true,
        descriptionKey = "KEYWORD",
        description = "KEYWORD",
        validateWith = CLIKeyWordValidator.class
    )
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "Cada busqueda puede incluir una ubicacion"
    )
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "La API devuelve 50 resultados, usa un numero para la pagina"
    )
    private int page;

    @Parameter(
            names = {"--full-time"},
            description = "Agrega si queremos trabajos de tiempo completo"
    )
    private boolean isFulltime;

    @Parameter(
            names = "--markdown",
            description = "Obtener los resultados en markdown"
    )
    private boolean isMarkDown;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Mostrar ayuda"
    )
    private boolean isHelp;

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFulltime() {
        return isFulltime;
    }

    public boolean isMarkDown() {
        return isMarkDown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFulltime=" + isFulltime +
                ", isMarkDown=" + isMarkDown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}
