/*
 * Copyright (C) 2016 Bradley Campbell.
 *
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

package nz.bradcampbell.benchmarkdemo.parceltasks;

import android.os.Parcel;
import nz.bradcampbell.benchmarkdemo.model.parceler.ParcelerResponse;
import org.parceler.Parcels;

public class ParcelerTask extends ParcelTask<ParcelerResponse> {
  public ParcelerTask(ParcelListener parcelListener, ParcelerResponse response) {
    super(parcelListener, response);
  }

  @Override protected int writeThenRead(ParcelerResponse response, Parcel parcel) {
    parcel.writeParcelable(Parcels.wrap(response), 0);
    parcel.setDataPosition(0);
    ParcelerResponse out = Parcels.unwrap(parcel.readParcelable(ParcelerResponse.class.getClassLoader()));
    return out.getUsers().size();
  }
}
