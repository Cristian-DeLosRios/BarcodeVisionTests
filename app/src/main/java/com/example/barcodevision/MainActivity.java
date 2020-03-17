/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.barcodevision;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.barcodevision.R;
/** Entry activity to select the detection mode. */
public class MainActivity extends AppCompatActivity {

    private enum DetectionMode {
        ODT_LIVE(R.string.mode_odt_live_title, R.string.mode_odt_live_subtitle),
        ODT_STATIC(R.string.mode_odt_static_title, R.string.mode_odt_static_subtitle),
        BARCODE_LIVE(R.string.mode_barcode_live_title, R.string.mode_barcode_live_subtitle);

        private final int titleResId;
        private final int subtitleResId;

        DetectionMode(int titleResId, int subtitleResId) {
            this.titleResId = titleResId;
            this.subtitleResId = subtitleResId;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main);

        RecyclerView modeRecyclerView = findViewById(R.id.mode_recycler_view);
        modeRecyclerView.setHasFixedSize(true);
        modeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        modeRecyclerView.setAdapter(new ModeItemAdapter(DetectionMode.values()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!Utils.allPermissionsGranted(this)) {
            Utils.requestRuntimePermissions(this);
        }
    }

            }
        }
    }
}
