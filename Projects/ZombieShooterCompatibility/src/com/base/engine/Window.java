package com.base.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window 
{
	public static void createWindow(int width, int height, String title, boolean fullFlag)
	{
		Display.setTitle(title);
		try
		{
			DisplayMode displayMode = null;
			DisplayMode[] modes = Display.getAvailableDisplayModes();

			for (int i = 0; i < modes.length; i++)
			{
				if (modes[i].getWidth() == width
						&& modes[i].getHeight() == height
						&& modes[i].isFullscreenCapable())
				{
					displayMode = modes[i];
				}
			}
			if(displayMode == null)
			{
				displayMode = new DisplayMode(width,height);
			}
            Display.setDisplayMode(displayMode);
			Display.setFullscreen(fullFlag);
			Display.create();
			Keyboard.create();
			Mouse.create();
		} 
		catch (LWJGLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void render()
	{
		Display.update();
	}

	public static void Fullscreen()
	{
		dispose();
		if(Display.isFullscreen()==false)
		{
			createWindow(800,600,"Zombie Shooter Compatibility",true);
		}
		else
		{
			createWindow(800,600,"Zombie Shooter Compatibility",false);
		}
		//Game.getLevel().render();
		//Game.getLevel().update();
		render();


	}

	public static void dispose()
	{
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}
	
	public static boolean isCloseRequested()
	{
		return Display.isCloseRequested();
	}
	
	public static int getWidth()
	{
		return Display.getDisplayMode().getWidth();
	}
	
	public static int getHeight()
	{
		return Display.getDisplayMode().getHeight();
	}
	
	public static String getTitle()
	{
		return Display.getTitle();
	}
}
