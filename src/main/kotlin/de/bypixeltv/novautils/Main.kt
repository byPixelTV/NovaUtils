package de.bypixeltv.novautils

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkit
import dev.jorel.commandapi.CommandAPIBukkitConfig
import net.axay.kspigot.chat.sendMessage
import net.axay.kspigot.main.KSpigot
import net.kyori.adventure.text.minimessage.MiniMessage
import net.milkbowl.vault.chat.Chat
import org.bukkit.plugin.RegisteredServiceProvider

class Main : KSpigot() {
    companion object {
        lateinit var INSTANCE: Main; private set
        var chat: Chat? = null
    }

    override fun load() {
        INSTANCE = this
        val miniMessages = MiniMessage.miniMessage()
        CommandAPI.onLoad(CommandAPIBukkitConfig(this).silentLogs(true).verboseOutput(true))
        server.consoleSender.sendMessage(miniMessages.deserialize("<blue>Enabling NovaUtils v1...</blue>"))
        server.consoleSender.sendMessage(" ")
        server.consoleSender.sendMessage(" ")
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua> _   _                       _   _  _    _  _      </aqua>"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua>| \\ | |  ___  __   __  __ _ | | | || |_ (_)| | ___ </aqua>"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua>|  \\| | / _ \\ \\ \\ / / / _` || | | || __|| || |/ __|</aqua>"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua>| |\\  || (_) | \\ V / | (_| || |_| || |_ | || |\\__ \\"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua>|_| \\_| \\___/   \\_/   \\__,_| \\___/  \\__||_||_||___/</aqua>"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<yellow>Made by byPixelTV</yellow>"))
        server.consoleSender.sendMessage(" ")
        server.consoleSender.sendMessage(" ")
        server.consoleSender.sendMessage(miniMessages.deserialize("<blue>Successfully enabled NovaUtils v1! <yellow>Good to see you :)</yellow></blue>"))
    }

    override fun startup() {
        INSTANCE = this
        CommandAPI.onEnable()
//      CommandAPIBukkit.unregister("heal", true, true)
        setupChat()
    }

    override fun shutdown() {
        val miniMessages = MiniMessage.miniMessage()
        CommandAPI.onDisable()
        server.consoleSender.sendMessage(miniMessages.deserialize("<blue>Disabling NovaUtils v1...</blue>"))
        server.consoleSender.sendMessage(" ")
        server.consoleSender.sendMessage(" ")
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua> _   _                       _   _  _    _  _      </aqua>"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua>| \\ | |  ___  __   __  __ _ | | | || |_ (_)| | ___ </aqua>"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua>|  \\| | / _ \\ \\ \\ / / / _` || | | || __|| || |/ __|</aqua>"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua>| |\\  || (_) | \\ V / | (_| || |_| || |_ | || |\\__ \\"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<aqua>|_| \\_| \\___/   \\_/   \\__,_| \\___/  \\__||_||_||___/</aqua>"))
        server.consoleSender.sendMessage(miniMessages.deserialize("<yellow>Made by byPixelTV</yellow>"))
        server.consoleSender.sendMessage(" ")
        server.consoleSender.sendMessage(" ")
        server.consoleSender.sendMessage(miniMessages.deserialize("<blue>Successfully disabled NovaUtils v1! <yellow>See you soon :)</yellow></blue>"))
    }

    private fun setupChat() {
        if (server.pluginManager.getPlugin("Vault") == null) {
            logger.severe("Vault not found! Disabling plugin...")
            server.pluginManager.disablePlugin(this)
            return
        }

        val rsp: RegisteredServiceProvider<Chat> = server.servicesManager.getRegistration(Chat::class.java) ?: return
        chat = rsp.provider

    }

}