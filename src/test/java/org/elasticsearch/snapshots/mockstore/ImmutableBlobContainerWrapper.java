/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.snapshots.mockstore;

import com.google.common.collect.ImmutableMap;
import org.elasticsearch.common.blobstore.BlobMetaData;
import org.elasticsearch.common.blobstore.BlobPath;
import org.elasticsearch.common.blobstore.ImmutableBlobContainer;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class ImmutableBlobContainerWrapper implements ImmutableBlobContainer {
    private ImmutableBlobContainer delegate;

    public ImmutableBlobContainerWrapper(ImmutableBlobContainer delegate) {
        this.delegate = delegate;
    }

    @Override
    public void writeBlob(String blobName, InputStream is, long sizeInBytes, WriterListener listener) {
        delegate.writeBlob(blobName, is, sizeInBytes, listener);
    }

    @Override
    public void writeBlob(String blobName, InputStream is, long sizeInBytes) throws IOException {
        delegate.writeBlob(blobName, is, sizeInBytes);
    }

    @Override
    public BlobPath path() {
        return delegate.path();
    }

    @Override
    public boolean blobExists(String blobName) {
        return delegate.blobExists(blobName);
    }

    @Override
    public void readBlob(String blobName, ReadBlobListener listener) {
        delegate.readBlob(blobName, listener);
    }

    @Override
    public byte[] readBlobFully(String blobName) throws IOException {
        return delegate.readBlobFully(blobName);
    }

    @Override
    public boolean deleteBlob(String blobName) throws IOException {
        return delegate.deleteBlob(blobName);
    }

    @Override
    public void deleteBlobsByPrefix(String blobNamePrefix) throws IOException {
        delegate.deleteBlobsByPrefix(blobNamePrefix);
    }

    @Override
    public void deleteBlobsByFilter(BlobNameFilter filter) throws IOException {
        delegate.deleteBlobsByFilter(filter);
    }

    @Override
    public ImmutableMap<String, BlobMetaData> listBlobs() throws IOException {
        return delegate.listBlobs();
    }

    @Override
    public ImmutableMap<String, BlobMetaData> listBlobsByPrefix(String blobNamePrefix) throws IOException {
        return delegate.listBlobsByPrefix(blobNamePrefix);
    }
}
