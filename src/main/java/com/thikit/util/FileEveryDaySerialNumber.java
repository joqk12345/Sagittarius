package com.thikit.util;

/**
 * system model name
 * com.isoft.finance.util
 * FileEveryDaySerialNumber.java
 * 2013-5-1-����6:52:41
 */

import java.io.File;
import java.util.Date;
import java.util.List;


public class FileEveryDaySerialNumber extends EveryDaySerialNumber{

	/**
	 * �־û��洢���ļ�
	 */
	private File file = null;

	/**
	 * �洢�ķָ���
	 */
	private final static String FIELD_SEPARATOR = ",";

	public FileEveryDaySerialNumber(int width, String filename) {
		super(width);
		file = new File(filename);
	}

	@Override
	protected int getOrUpdateNumber(Date current, int start) {
		String date = format(current);
		int num = start;
		if (file.exists()) {
			List<String> list = FileUtil.readList(file);
			String[] data = list.get(0).split(FIELD_SEPARATOR);
			if (date.equals(data[0])) {
				num = Integer.parseInt(data[1]);
			}
		}
		FileUtil.write(file, date + FIELD_SEPARATOR + (num + 1));
		return num;
	}


}
