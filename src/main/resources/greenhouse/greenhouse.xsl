<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Flower Plants</h2>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Soil</th>
                        <th>Origin</th>
                        <th>Stem Color</th>
                        <th>Leaf Color</th>
                        <th>Size</th>
                        <th>Temperature</th>
                        <th>Loves Light</th>
                        <th>Watering</th>
                        <th>Multiplying Type</th>
                    </tr>
                    <xsl:for-each select="flower/plant">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="soil"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td><xsl:value-of select="visualParameters/stemColor"/></td>
                            <td><xsl:value-of select="visualParameters/leafColor"/></td>
                            <td><xsl:value-of select="visualParameters/size"/></td>
                            <td><xsl:value-of select="growingTips/temperature"/></td>
                            <td><xsl:value-of select="growingTips/lovesLight"/></td>
                            <td><xsl:value-of select="growingTips/watering"/></td>
                            <td><xsl:value-of select="multiplyingType"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>