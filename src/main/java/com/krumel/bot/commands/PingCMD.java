
        package com.krumel.bot.commands;

        import java.time.temporal.ChronoUnit;
        import com.jagrosh.jdautilities.command.Command;
        import com.jagrosh.jdautilities.command.CommandEvent;
        import com.jagrosh.jdautilities.doc.standard.CommandInfo;
        import com.jagrosh.jdautilities.examples.doc.Author;
        /*
         *
         *
         * Written by Lukas H. (ZickZackHD)
         * 2018, July
         *
         *
         */
        /**
         *
         * @author Lukas H.
         *
         */

@CommandInfo(
        name = {"Ping", "Pong"},
        description = "Checks the bot's latency"
)
@Author("Heinz")
public class PingCMD extends Command {

    public PingCMD()
    {
        this.name = "ping";
        this.help = "checks the bot's latency";
        this.guildOnly = false;
        this.aliases = new String[]{"pong"};
    }

    @Override
    protected void execute(CommandEvent event) {
        event.reply("Ping: ...", m -> {
            long ping = event.getMessage().getCreationTime().until(m.getCreationTime(), ChronoUnit.MILLIS);
            m.editMessage("Ping: " + ping  + "ms | Websocket: " + event.getJDA().getPing() + "ms").queue();
        });
    }

}
