#!/usr/bin/env python
# coding: utf-8

# In[1]:


import folium
import folium.plugins as plugins
from folium.plugins import HeatMapWithTime

import webbrowser
# In[2]:


import pandas as pd
import folium
import sys
import os

# In[17]:

print("Number of aruguments ",len(sys.argv))

s = (sys.argv)
s.remove(s[0])
l = " "
for eachArgument in s:
    l += eachArgument+" "



column_names = ['Vehicle_Code', 'V_Lat', 'V_Long', 'Ward_Location', 'Cause', 'Speed', 'Date']

print(l)
df1 = pd.read_csv(l.strip(),header=None)

col_len = len(df1.columns)

if(col_len == 2):
    column_names = ['V_Lat','V_Long']

df1.columns = column_names


# In[21]:


#df1['Date'] = pd.to_datetime(df1['Date'], format = '%d-%m-%Y')


# In[22]:


cols_to_convert = ['V_Lat', 'V_Long']


# In[23]:


for col in cols_to_convert:
    df1[col] = pd.to_numeric(df1[col], errors = 'coerce')

# In[25]:


df_map = df1.copy()
df_map[['V_Lat', 'V_Long']].groupby(['V_Lat','V_Long'])
df_map.shape


# In[37]:



#def generateBaseMap(default_location=[40.5397293,-74.6273494], default_zoom_start=12):
#    base_map = folium.Map(location=default_location, control_scale=True, zoom_start=default_zoom_start)
#    return base_map

#base_map = generateBaseMap()
#base_map
#m = HeatMap(data=df_map[['V_Lat', 'V_Long']].groupby(['V_Lat','V_Long']).sum().reset_index().values.tolist(), radius=7, max_zoom=10).add_to(base_map)
#m.save('heatmap.html')


# In[33]:


#get_ipython().system('pip -q install folium')


# In[36]:


from folium.plugins import HeatMap
def generateBaseMap(default_location=[40.866667, 34.566667], default_zoom_start=3):
    base_map = folium.Map(location=default_location, control_scale=True, zoom_start=default_zoom_start)
    return base_map

base_map = generateBaseMap()
base_map
m = HeatMap(data=df_map[['V_Lat', 'V_Long']].groupby(['V_Lat','V_Long']).sum().reset_index().values.tolist(), radius=7, max_zoom=10).add_to(base_map)
m.save('D:\\HeatMap.html')

webbrowser.open_new_tab('D:\\HeatMap.html')
# In[ ]:


# In[ ]:





# In[ ]:
