/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.webkit.internal;

import android.webkit.WebView;

import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/**
 * Adapter for WebViewProviderFactoryBoundaryInterface providing static WebView functionality
 * similar to that provided by {@link android.webkit.WebViewFactoryProvider}.
 */
public class WebViewProviderFactoryAdapter {
    WebViewProviderFactoryBoundaryInterface mImpl;

    public WebViewProviderFactoryAdapter(WebViewProviderFactoryBoundaryInterface impl) {
        mImpl = impl;
    }

    /**
     * Adapter method for creating a new support library version of
     * {@link android.webkit.WebViewProvider} - the class used to implement
     * {@link androidx.webkit.WebViewCompat}.
     */
    public WebViewProviderBoundaryInterface createWebView(WebView webview) {
        return BoundaryInterfaceReflectionUtil.castToSuppLibClass(
                WebViewProviderBoundaryInterface.class, mImpl.createWebView(webview));
    }
}
