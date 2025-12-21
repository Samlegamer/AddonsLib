package fr.samlegamer.addonslib;

import fr.addonslib.api.log.McwLogFilterList;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.filter.AbstractFilter;

public class CustomLogFilter extends AbstractFilter {
    @Override
    public Result filter(LogEvent event) {
        for(String ignored : McwLogFilterList.INSTANCE.getList()) {
            if(event.getMessage().getFormattedMessage().contains(ignored)) {
                return Result.DENY;
            }
        }
        return Result.NEUTRAL;
    }
}