package com.bernal.inditex.prices.worker.services;

public class FileLoadPricesService implements LoaderPricesService {

	private String filenamePath;

	public FileLoadPricesService(String filenamePath) {

		this.filenamePath = filenamePath;
	}

	@Override
	public void load() {

	}
}
