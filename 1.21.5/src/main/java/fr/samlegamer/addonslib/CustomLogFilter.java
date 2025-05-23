package fr.samlegamer.addonslib;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.filter.AbstractFilter;

public class CustomLogFilter extends AbstractFilter {
    @Override
    public Result filter(LogEvent event) {
        if (event.getMessage().getFormattedMessage().contains("Exception loading blockstate definition")
                || event.getMessage().getFormattedMessage().contains("Failed to load blockstate definition")
        || event.getMessage().getFormattedMessage().contains("Missing block model")
                || event.getMessage().getFormattedMessage().contains("Missing model for variant")
                || event.getMessage().getFormattedMessage().contains("Missing blockstate definition")){
            return Result.DENY;
        }
        return Result.NEUTRAL;
    }
}