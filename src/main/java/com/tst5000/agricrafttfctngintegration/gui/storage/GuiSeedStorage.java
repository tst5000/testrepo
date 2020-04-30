package com.tst5000.agricrafttfctngintegration.gui.storage;

import com.tst5000.agricrafttfctngintegration.api.v1.seed.AgriSeed;
import com.tst5000.agricrafttfctngintegration.container.ContainerSeedStorage;
import com.tst5000.agricrafttfctngintegration.gui.AgriGuiWrapper;
import com.tst5000.agricrafttfctngintegration.gui.component.BasicComponents;
import com.tst5000.agricrafttfctngintegration.network.MessageGuiSeedStorageClearSeed;
import com.tst5000.agricrafttfctngintegration.reference.Reference;
import com.tst5000.agricrafttfctngintegration.tiles.storage.TileEntitySeedStorage;
import java.util.Optional;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSeedStorage extends GuiSeedStorageBase {

    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/gui_seed_storage.png");

    private final Optional<AgriSeed> activeSeed;

    public GuiSeedStorage(InventoryPlayer inventory, TileEntitySeedStorage te) {
        super(new ContainerSeedStorage(te, inventory), 0, 14, 170, 48, -1, -1, 5, 7);
        this.activeSeed = te.getLockedSeed();
    }

    @Override
    protected void onComponentGuiInit(AgriGuiWrapper wrapper) {
        super.onComponentGuiInit(wrapper);
        this.addComponent(BasicComponents.getButtonComponent("X", 211, 105, 18, 18, (c, p) -> clearSeed()));
        this.clearBackgrounds();
        this.addBackground(texture);
    }

    /*
    @Override
    public void onRenderBackground(AgriGuiWrapper wrapper, float f, int relMouseX, int relMouseY) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        wrapper.drawTexturedModalRect(0, 0, 0, 0, this.getWidth(), this.getHeight());
        if (this.activeSeed != null) {
            this.drawActiveEntries(wrapper, texture, 6, 35);
        }
        this.drawScrollBarHorizontal(wrapper, texture);
    }
     */
    private boolean clearSeed() {
        new MessageGuiSeedStorageClearSeed(Minecraft.getMinecraft().player).sendToServer();
        //this.updateScreen();
        return true;
    }
}
