package fr.samlegamer.addonslib;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.filter.AbstractFilter;

public class CustomLogFilter extends AbstractFilter {
    @Override
    public Result filter(LogEvent event) {
        if (event.getMessage().getFormattedMessage().contains("Exception loading blockstate definition")
                || event.getMessage().getFormattedMessage().contains("Exception evaluating model definition")
                || event.getMessage().getFormattedMessage().contains("Failed to load blockstate definition")
                || event.getMessage().getFormattedMessage().contains("Missing block model")
                || event.getMessage().getFormattedMessage().contains("Missing model for variant")
                || event.getMessage().getFormattedMessage().contains("Using missing texture, unable to load")
                || event.getMessage().getFormattedMessage().contains("Unable to load model")
                || event.getMessage().getFormattedMessage().contains("Unable to bake model")
                || event.getMessage().getFormattedMessage().contains("Unable to resolve texture reference")
                || (event.getMessage().getFormattedMessage().contains("Skipping loading recipe") &&
                event.getMessage().getFormattedMessage().contains("as it's serializer returned null"))){
            return Result.DENY;
        }
        return Result.NEUTRAL;
    }
}