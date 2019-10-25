.. mycoder documentation master file, created by
   sphinx-quickstart on Thu May 07 13:23:47 2015.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

mycoder文档
===================================
项目简介
------------------


功能: :: 

    可以在PC上编辑HTML内容，android端用浏览器直接查看编辑后效果


实现: ::

    android利用NanoHTTPD实际简易HTTP服务，查看文件列表

    编辑时，读取文件内容，根据codemirror生成编辑页面

    保存时，把POST的数据保存在文件原来的位置




.. toctree::
   :maxdepth: 2

.. image:: _static/images/device1.png
.. image:: _static/images/pc1.png
.. image:: _static/images/pc2.png


Indices and tables
==================

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`

