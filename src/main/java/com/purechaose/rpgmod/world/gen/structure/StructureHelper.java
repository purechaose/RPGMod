package com.purechaose.rpgmod.world.gen.structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class StructureHelper {
	
	public Block[][][] readStructureFromFile(File f) {
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int x = Integer.parseInt(s.nextLine());
		int y = Integer.parseInt(s.nextLine());
		int z = Integer.parseInt(s.nextLine());
		Block[][][] struct = new Block[x][y][z];
		for(int i = 0; i<struct.length; i++)
			for(int j = 0; j<struct.length; j++)
				for(int k = 0; k<struct.length; k++)
					struct[i][j][k] = Block.getBlockFromName(s.nextLine());
		return struct;
	}
	
	public void writeStructureToFile(File f, Block[][][] struct) {
		PrintWriter o = null;
		try {
			o = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		o.println(struct.length+"\n"+struct[0].length+"\n"+struct[0][0].length+"\n");

		for(int i = 0; i<struct.length; i++)
			for(int j = 0; j<struct.length; j++)
				for(int k = 0; k<struct.length; k++)
					o.println(struct[i][j][k].getLocalizedName());
	}
	
	public void writeStructureToFile(File f, World w, Point3d start, Point3d end) {
		Block[][][] struct = new Block[(int) Math.abs(start.x-end.x)][(int) Math.abs(start.y-end.y)][(int) Math.abs(start.z-end.z)];
		for(int i = (int) start.x; i<(int) end.x; i++)
			for(int j = (int) start.y; j<(int) end.y; j++)
				for(int k = (int) start.z; k<(int) end.z; k++)
					struct[(int) (i-start.x)][(int) (j-start.y)][(int) (k-start.z)] = w.getBlock(i, j, k);
		writeStructureToFile(f, struct);
	}
	
	public void writeStructureToWorld(World w, Block[][][] struct, Point3d start) {
		for(int i=0; i<struct.length; i++)
			for(int j=0; j<struct.length; j++)
				for(int k=0; k<struct.length; k++)
					w.setBlock((int)(start.x)+i, (int)(start.y)+j, (int)(start.z)+k, struct[i][j][k]);
	}
}
