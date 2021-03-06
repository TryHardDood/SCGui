package hu.tryharddood.scgui.Objects;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import hu.tryharddood.scgui.SCGui;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.concurrent.TimeoutException;

import static hu.tryharddood.scgui.Logger.Console.Prefix.ERROR;
import static hu.tryharddood.scgui.Logger.Console.Prefix.INFO;

/*****************************************************
 *              Created by TryHardDood on 2016. 08. 18..
 ****************************************************/
public class Player {

	private final SimpleIntegerProperty userid;
	private final SimpleStringProperty  steamid;
	private final SimpleStringProperty  ip;
	private final SimpleStringProperty  name;

	private final SimpleIntegerProperty rate;
	private final SimpleStringProperty  connect;
	private final SimpleIntegerProperty ping;


	public Player(Integer userid, String playername, String steamid, String playerip, int rate, String connectTime, int ping) {
		this.userid = new SimpleIntegerProperty(userid);
		this.steamid = new SimpleStringProperty(steamid);
		this.ip = new SimpleStringProperty(playerip);
		this.name = new SimpleStringProperty(playername);

		this.rate = new SimpleIntegerProperty(rate);
		this.connect = new SimpleStringProperty(connectTime);
		this.ping = new SimpleIntegerProperty(ping);
	}

	public int getUserid() {
		return userid.get();
	}

	public SimpleIntegerProperty useridProperty() {
		return userid;
	}

	public String getSteamid() {
		return steamid.get();
	}

	public SimpleStringProperty steamidProperty() {
		return steamid;
	}

	public String getIp() {
		return ip.get();
	}

	public SimpleStringProperty ipProperty() {
		return ip;
	}

	public String getName() {
		return name.get();
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public int getRate() {
		return rate.get();
	}

	public SimpleIntegerProperty rateProperty() {
		return rate;
	}

	public String getConnect() {
		return connect.get();
	}

	public SimpleStringProperty connectProperty() {
		return connect;
	}

	public int getPing() {
		return ping.get();
	}

	public SimpleIntegerProperty pingProperty() {
		return ping;
	}

	public void kickPlayer(Server server) {
		SCGui.getLogger().println(INFO, "Trying to kick player " + getName());
		try
		{
			server.rconExec("kick \"" + getName() + "\"");
		} catch (TimeoutException | SteamCondenserException e)
		{
			SCGui.getLogger().println(ERROR, "Couldn't kick player " + getName());
			e.printStackTrace();
		}
	}

	public void banPlayer(Server server, String s) {

		SCGui.getLogger().println(INFO, "Trying to ban player " + getName());
		try
		{
			server.rconExec("banid " + Integer.valueOf(s) + " \"" + getSteamid() + "\"");
		} catch (TimeoutException | SteamCondenserException e)
		{
			SCGui.getLogger().println(ERROR, "Couldn't ban player " + getName());
			e.printStackTrace();
		}
	}
}