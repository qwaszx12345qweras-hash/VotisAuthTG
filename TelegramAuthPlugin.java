package ru.твоё_имя.telegramauth;

import org.bukkit.plugin.java.JavaPlugin;

public final class TelegramAuthPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("TelegramAuth включён!");
        // Регистрация команд и слушателей
        getCommand("link").setExecutor(new LinkCommand(this));
        getServer().getPluginManager().registerEvents(new FreezeListener(this), this);
        // Запуск Telegram-бота
        new TelegramBot(this).start();
    }

    @Override
    public void onDisable() {
        getLogger().info("TelegramAuth выключен.");
    }
}
