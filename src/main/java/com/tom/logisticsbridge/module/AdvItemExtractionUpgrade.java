package com.tom.logisticsbridge.module;

import com.tom.logisticsbridge.pipe.BridgePipe;
import com.tom.logisticsbridge.pipe.ResultPipe;
import logisticspipes.pipes.basic.CoreRoutedPipe;
import logisticspipes.pipes.upgrades.ItemExtractionUpgrade;
import org.apache.commons.lang3.ArrayUtils;

public class AdvItemExtractionUpgrade extends ItemExtractionUpgrade {
    public static String getName() {
        return "adv_item_extraction";
    }

    @Override
    public boolean needsUpdate() {
        return false;
    }

    @Override
    public boolean isAllowedForPipe(CoreRoutedPipe pipe) {
        return pipe instanceof BridgePipe || pipe instanceof ResultPipe || super.isAllowedForPipe(pipe);
    }

    @Override
    public String[] getAllowedPipes() {
        return ArrayUtils.addAll(super.getAllowedPipes(), "bridge", "result");
    }
}
