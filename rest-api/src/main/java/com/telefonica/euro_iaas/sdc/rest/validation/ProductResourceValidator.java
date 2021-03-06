/**
 * Copyright 2014 Telefonica Investigación y Desarrollo, S.A.U <br>
 * This file is part of FI-WARE project.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License.
 * </p>
 * <p>
 * You may obtain a copy of the License at:<br>
 * <br>
 * http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * </p>
 * <p>
 * See the License for the specific language governing permissions and limitations under the License.
 * </p>
 * <p>
 * For those usages not covered by the Apache version 2.0 License please contact with opensource@tid.es
 * </p>
 */

package com.telefonica.euro_iaas.sdc.rest.validation;

import org.glassfish.jersey.media.multipart.MultiPart;

import com.telefonica.euro_iaas.commons.dao.AlreadyExistsEntityException;
import com.telefonica.euro_iaas.commons.dao.EntityNotFoundException;
import com.telefonica.euro_iaas.commons.dao.InvalidEntityException;
import com.telefonica.euro_iaas.sdc.exception.InvalidMultiPartRequestException;
import com.telefonica.euro_iaas.sdc.exception.InvalidProductException;
import com.telefonica.euro_iaas.sdc.exception.InvalidProductReleaseUpdateRequestException;
import com.telefonica.euro_iaas.sdc.model.Product;
import com.telefonica.euro_iaas.sdc.model.dto.ProductReleaseDto;
import com.telefonica.euro_iaas.sdc.model.dto.ReleaseDto;

/**
 * Defines the methods to validate the selected operation is valid for the given Application Release.
 * 
 * @author Jesus M. Movilla
 */
public interface ProductResourceValidator {

    /**
     * Verify if the ProductRelase could be updated.
     * 
     * @param ReleaseDto
     *            (name, version, type)
     * @param MultiPart
     *            composed of three objects: ApplicationReleaseDto, File cookbook and File installable
     */
    void validateUpdate(ReleaseDto rleleaseDto, MultiPart multipart) throws InvalidMultiPartRequestException,
            InvalidProductReleaseUpdateRequestException;

    /**
     * Verify if the ProductRelase could be inserted
     * 
     * @param MultiPart
     *            composed of three objects: ApplicationReleaseDto, File cookbook and File installable
     */
    void validateInsert(MultiPart multipart) throws InvalidMultiPartRequestException;

    /**
     * Verify if the ProductRelase could be inserted
     * 
     * @param product
     *            (name, version, type)
     * @throws AlreadyExistsEntityException
     * @throws InvalidProductException 
     */
    void validateInsert(Product product) throws InvalidEntityException, AlreadyExistsEntityException, InvalidProductException;

    /**
     * @param pName
     * @param productRelease
     * @throws InvalidEntityException
     * @throws AlreadyExistsEntityException
     * @throws EntityNotFoundException
     */
    void validateInsert(String pName, ProductReleaseDto productRelease) throws InvalidEntityException,
            EntityNotFoundException;

    /**
     * @param releaseDto
     * @throws EntityNotFoundException
     */
    public void validateLoad(ReleaseDto releaseDto) throws EntityNotFoundException;
}
