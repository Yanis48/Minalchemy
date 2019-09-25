package com.yanis48.minalchemy;

import com.yanis48.minalchemy.container.AlchemyTableContainer;
import com.yanis48.minalchemy.container.AlchemyTableScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;

public class MinalchemyClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ScreenProviderRegistry.INSTANCE.registerFactory(Minalchemy.ALCHEMY_TABLE_CONTAINER, (syncId, identifier, player, buf) -> {
			return new AlchemyTableScreen(new AlchemyTableContainer(syncId, player), syncId, player);
		});
	}
}
