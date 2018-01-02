/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liorkn.elasticsearch.plugin;

import com.liorkn.elasticsearch.script.VectorScoreScript;
import com.liorkn.elasticsearch.service.VectorScoringScriptEngineService;

import java.util.Collections;
import java.util.List;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.ScriptPlugin;
import org.elasticsearch.script.NativeScriptFactory;
import org.elasticsearch.script.ScriptEngineService;

/**
 * This class is instantiated when Elasticsearch loads the plugin for the
 * first time. If you change the name of this plugin, make sure to update
 * src/main/resources/es-plugin.properties file that points to this class.
 */
public final class VectorScoringPlugin extends Plugin implements ScriptPlugin {
	
	@Override
    public List<NativeScriptFactory> getNativeScripts() {
        return Collections.singletonList(new VectorScoreScript.Factory());
    }
	
	@Override
	public ScriptEngineService getScriptEngineService(Settings settings) {
        return new VectorScoringScriptEngineService(settings);
    }
}