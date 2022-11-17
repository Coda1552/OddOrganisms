package coda.oddorganisms.data;

import net.minecraft.nbt.CompoundTag;

public class EmbryoData {
    private int timer;

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void saveNBTData(CompoundTag tag) {
        tag.putInt("embryoTimer", timer);
    }

    public void loadNBTData(CompoundTag tag) {
        timer = tag.getInt("embryoTimer");
    }
}

