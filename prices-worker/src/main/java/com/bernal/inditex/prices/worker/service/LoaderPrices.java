package com.bernal.inditex.prices.worker.service;

import com.bernal.inditex.prices.worker.domain.errors.MissingFilePathException;
import org.springframework.stereotype.Service;

@Service
public interface LoaderPrices {
	void load() throws  MissingFilePathException;
}
