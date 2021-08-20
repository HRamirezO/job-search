package com.jobs.search;

import com.beust.jcommander.JCommander;
import com.jobs.search.api.IAPIFunctions;
import com.jobs.search.api.IAPIJobs;
import com.jobs.search.cli.CLIArguments;
import com.jobs.search.cli.CLIFunctions;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class JobSearch {

    public static void main(String[] args) {
        JCommander jCommander = CommanderFunctions.buildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCli =
                CommanderFunctions.parseArguments(jCommander, args, JCommander::usage)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCli.filter(cli -> !cli.isHelp())
                        .filter(cli -> cli.getKeyword() != null)
                        .findFirst();


        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params){
        IAPIJobs api = IAPIFunctions.buildAPI(IAPIJobs.class, "https://jobs.github.com");

        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);

    }
}
